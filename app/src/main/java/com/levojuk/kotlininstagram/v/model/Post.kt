package com.levojuk.kotlininstagram.v.model

import com.google.firebase.Timestamp

data class Post (val email : String , val comment :String,val downloadUrl :String ,val timestamp: Timestamp) {
}