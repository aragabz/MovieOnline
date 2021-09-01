package com.ragabz.movieonline.di.qualifiers

import javax.inject.Qualifier


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
public annotation class LocalDatasource


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
public annotation class RemoteDatasource