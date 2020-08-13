package flowable

import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

object Flowable {

    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Flowable is an observable that should be used when an Observable is generating huge amounts of data
     * that the Observer is not able to handle these data emissions.
     *There are two main aspects where we use Flowable:
     * 1. Complex cases where huge amounts of data flow that UI can’t handle
     * 2. To get notified when there is a change in data already observed
     */
    @JvmStatic
    fun main(args: Array<String>) {
        testingFlowable()
    }

    private fun testingFlowable() {
        Flowable.fromArray(1, 2, 3, 4).subscribe(
                { i: Int? -> println("Entry  $i") },
                { e: Throwable? -> println("Failed to process: $e") }
        ) { println("Done") }
    }


}