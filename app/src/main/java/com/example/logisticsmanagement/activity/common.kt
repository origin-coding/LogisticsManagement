package com.example.logisticsmanagement.activity

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

val PRIMARY_TEXT_SIZE = 24.sp
val SECONDARY_TEXT_SIZE = 20.sp

@Composable
fun TextDialog(
    showDialog: MutableState<Boolean>,
    title: String,
    message: String,
    confirmText: String? = null
) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = title, fontSize = SECONDARY_TEXT_SIZE) },
            text = { Text(text = message, fontSize = PRIMARY_TEXT_SIZE) },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = confirmText ?: "确认", fontSize = SECONDARY_TEXT_SIZE)
                }
            },
            modifier = Modifier.width(320.dp)
        )
    }
}

@Composable
fun CustomContentDialog(
    showDialog: MutableState<Boolean>,
    title: String,
    confirmText: String? = null,
    content: @Composable (() -> Unit),
) {
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = title, fontSize = SECONDARY_TEXT_SIZE) },
            text = { content() },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = confirmText ?: "确认", fontSize = SECONDARY_TEXT_SIZE)
                }
            }
        )
    }
}