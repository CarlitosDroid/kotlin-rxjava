package single

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import single.data.RepoImpl
import single.domain.Repo

object Single {

    private val disposables: CompositeDisposable = CompositeDisposable()

    /*
    * [Single] is an observable that emits only one item or throws an error.
    * In other words, Single is a reactive base type that can emit a single onSuccess or onError.
    * The simplest usage of Single in Android is when we make a network call to consume some data.
    * @link {https://medium.com/better-programming/rxjava-mastering-different-types-of-observables-154ca9849146}
    */

    @JvmStatic
    fun main(args: Array<String>) {
        val repo: Repo = RepoImpl()
        getShowDetails(repo)
    }

    private fun getShowDetails(repo: Repo) {
        repo.getShowDetails()
                .observeOn(Schedulers.computation())
                .subscribe({ seriesResponse ->
                    println("Series_data 1: ${seriesResponse.title}")
                    println("Series_data 2: ${seriesResponse.price}")
                }, {
                    print(it)
                }).let {
                    disposables.add(it)
                }
    }
}