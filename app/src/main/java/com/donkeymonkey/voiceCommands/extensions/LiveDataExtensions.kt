package com.donkeymonkey.voiceCommands.extensions

import androidx.lifecycle.MutableLiveData

//Used to notify about changes in LiveData that hold ArrayLists
fun  <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}