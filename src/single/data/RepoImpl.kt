package single.data

import io.reactivex.Single
import single.data.model.SeriesResponse
import single.domain.Repo

class RepoImpl: Repo {
    override fun getShowDetails(): Single<SeriesResponse> {
        return Single.just(SeriesResponse("Los Simpsons", "20.00"))
    }
}