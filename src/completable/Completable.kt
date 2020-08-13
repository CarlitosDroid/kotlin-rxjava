package completable

import completable.data.CacheService
import completable.data.CacheServiceImpl
import completable.data.repository.CacheRepoImpl
import completable.domain.CacheRepo
import completable.domain.model.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object Completable {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val cacheService: CacheService = CacheServiceImpl()
    private val cacheRepoImpl: CacheRepo = CacheRepoImpl(cacheService)

    /**
     * Completable is only concerned with execution completion without emitting a value.
     * Completable observable won’t emit any data instead it notifies the status of the task either success or failure.
     * We generally use Completable to store the values in preferences or SQLite local database, etc
     * where the response is not required.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val user = User("CarlitosDroid")
        saveUserDetails(user)
    }

    private fun saveUserDetails(user: User) {
        cacheRepoImpl.saveUserData(user)
                .observeOn(Schedulers.computation())
                .subscribe({
                    println("Data saved success case")
                }, {
                    println("Error case")
                }).let {
                    disposables.add(it)
                }
    }


}