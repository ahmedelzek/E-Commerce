package com.example.route.e_commerce.data.repos.sub_categories_repo

import com.example.route.e_commerce.domain.repos.sub_category_repo.SubCategoriesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun provideSubCategoriesRepo(
        subCategoriesRepoImpl: SubCategoriesRepoImpl
    ): SubCategoriesRepo

}