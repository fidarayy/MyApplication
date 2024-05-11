package org.d3if3138.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun WinOrLostDialog(
    text: String,
    buttonText: String,
    mysteryNumber: Int,
    image: Painter,
    resetGame: () -> Unit
) {
    Dialog(onDismissRequest = resetGame) {
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Angka Rahasianya adalah $mysteryNumber",
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        )

        Image(
            painter = image,
            contentDescription = "Result Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Button(
            onClick = resetGame,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        ) {
            Text(text = buttonText, fontSize = 18.sp)
        }
    }
}

@Composable
fun WiaDialogPrev() {
    WinOrLostDialog(
        text = "Selamat\nKamu menang",
        buttonText = "Main Lagi",
        mysteryNumber = 32,
        image = painterResource(R.drawable.ic_love),
        resetGame = {}
    )
}

@Composable
fun LostDialogPrev() {
    WinOrLostDialog(
        text = "Tidak Apa\nSemoga beruntung lain kali",
        buttonText = "Coba Lagi",
        mysteryNumber = 32,
        image = painterResource(R.drawable.ic_weird),
        resetGame = {}
    )
}
