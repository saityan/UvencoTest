package saityan.misc.uvencotest.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import saityan.misc.uvencotest.viewmodel.EditViewModel

@EntryPoint
@InstallIn(ActivityComponent::class)
interface EditViewModelFactoryProvider {
    fun editViewModelFactory(): EditViewModel.Factory
}