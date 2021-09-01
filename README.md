# ur-movies
android application to show movies using tmdb api 


splash |----> Login ---> HomeActivity 
       |------> Home Activity -->
                                 |--> Main    ---> MovieDetails
                                 |--> Search
                                 |--> profile
                                 |--> setting



 activity | Fragment --> viewmodel --> repository --> datasource --> 1- remote datasource  --> api
                                                                     2- local datasource   --> database (room | sqlite | realm | dbflow | greenrebot)
 


httpclient ( 1 )  --> ( 2 ) retrofit ( baseurl, GsonConverter ) --> ( 3 ) (interface) MovieAPi  -->  endpoint function (GET,POST,DELETE)

1- val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

2- val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .client(httpclient.build()).build()


3- var api = retrofit.create(MovieApi::class.java)

api --> object ( getMovies , getVideos, getRecommended)
