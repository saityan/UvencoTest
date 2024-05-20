package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import saityan.misc.uvencotest.model.Repository
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

}