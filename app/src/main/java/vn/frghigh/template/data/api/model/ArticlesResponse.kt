package vn.frghigh.template.data.api.model
import com.squareup.moshi.Json


data class ArticlesResponse(
		@Json(name ="status") var status: String?, //ok
		@Json(name ="source") var source: String?, //abc-news-au
		@Json(name ="sortBy") var sortBy: String?, //top
		@Json(name ="articles") var articles: List<Article>?
)

data class Article(
		@Json(name ="author") var author: String?, //http://www.abc.net.au/news/5511636, http://www.abc.net.au/news/lucy-sweeney/7114718
		@Json(name ="title") var title: String?, //Senate President reignites citizenship debacle, says father may be British
		@Json(name ="description") var description: String?, //Liberal senator Stephen Parry tells the Government he may be a dual citizen, saying he has asked British authorities to examine his history.
		@Json(name ="url") var url: String?, //http://www.abc.net.au/news/2017-10-31/stephen-parry-tells-government-his-father-may-be-british/9104482
		@Json(name ="urlToImage") var urlToImage: String?, //http://www.abc.net.au/news/image/9105122-1x1-700x700.jpg
		@Json(name ="publishedAt") var publishedAt: String? //2017-10-31T07:02:48Z
)