package Maybe

import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable

object Maybe {

    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Maybe observable may or may not emit a value.
     * This observable can be used in a case where you are expecting an item to be emitted optionally.
     * The [testMaybeStringWithValue] one outputs Hello inside onSuccess and does not emit an onComplete after that emission
     * The [testMaybeStringWithoutValue] one emits onComplete Completed. No items because there are no items to emit.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        testMaybeStringWithValue()
        //testMaybeStringWithoutValue()
    }

    private fun testMaybeStringWithValue(){
        Maybe.just("Hello")
                .subscribe(
                        { x: String ->
                            print("Emitted item: $x") // This is called
                        },
                        { ex: Throwable ->
                            println("Error: " + ex.message)
                        }
                ) {
                    println("Completed. No items.") //This is not called
                }.let {
                    disposables.dispose()
                }
    }

    private fun testMaybeStringWithoutValue(){
        Maybe.empty<String>()
                .subscribe(
                        { x: String -> print("Emitted item: $x") }, // This is not called
                        { ex: Throwable -> println("Error: " + ex.message) }
                ) {
                    println("Completed. No items.") // This is called
                }
                .let {
                    disposables.add(it)
                }

    }
}