package completable.data

import completable.domain.model.User

interface CacheService {
    fun saveUser(user: User)
}