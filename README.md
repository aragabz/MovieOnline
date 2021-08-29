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
 