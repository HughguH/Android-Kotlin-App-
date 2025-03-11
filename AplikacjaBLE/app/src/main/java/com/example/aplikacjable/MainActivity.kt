package com.example.aplikacjable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikacjable.ui.theme.AplikacjaBLETheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplikacjaBLETheme {
                backGround()
            }
        }
    }
}


@Composable
fun backGround() {
    var currentPage by remember { mutableStateOf("home") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Górny Box
        Box(
            modifier = Modifier
                .background(Color(0xFF48D8CF))
                .fillMaxWidth()
                .height(60.dp)
        )

        // Box, który zajmuje resztę przestrzeni
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(1f)  // Cała przestrzeń pomiędzy górnym a dolnym Box
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                when (currentPage){
                    "home"->displayTextHome(
                        modifier = Modifier,
                        imageRes = R.drawable.esp32_s3_devkitc_1_v1_isometric,
                        textRes = R.string.HomeTitle,
                        textRes2 = R.string.HomeDescription
                    )
                    "info"->displayInfo(
                        modifier = Modifier,
                        imageRes = R.drawable.esp32_s3_devkitc_1_n8_wifi_bluetooth_plytka_rozwojowa_z_ukladem_esp32_s3_wroom_11u,
                        imageRes2 = R.drawable.servo,
                        textRes = R.string.infoTitle,
                        textRes2 = R.string.infoDescriptionEsp,
                        textRes3 = R.string.infoDescriptionSerwo
                    )
                    "more"->extraOptions(
                        modifier = Modifier,
                        textRes = R.string.singleRegulation,
                        textRes2 = R.string.fullRegulation,
                        onClick = {}
                    )
                }

            }
        }

        // Box z przyciskami
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                buttonsOnGray(
                    modifier = Modifier.weight(1f),
                    imageRes = R.drawable.info_24dp_1f1f1f,
                    textRes = R.string.InfoText,
                    onClick = { currentPage = "info"}
                )
                buttonsOnGray(
                    modifier = Modifier.weight(1f),
                    imageRes = R.drawable.home_24dp_1f1f1f__1_,
                    textRes = R.string.HomeText,
                    onClick = { currentPage = "home" }
                )
                buttonsOnGray(
                    modifier = Modifier.weight(1f),
                    imageRes = R.drawable.more_vert_24dp_1f1f1f,
                    textRes = R.string.MoreText,
                    onClick = { currentPage = "more"} // Kliknięcie zmienia stan
                )
            }
        }

        // Dolny Box
        Box(
            modifier = Modifier
                .background(Color(0xFF48D8CF))
                .fillMaxWidth()
                .height(30.dp)
        )
    }
}

@Composable
fun buttonsOnGray(modifier: Modifier, imageRes: Int, textRes: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(30.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = stringResource(id = textRes),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun displayTextHome(modifier: Modifier, imageRes: Int, textRes: Int, textRes2: Int){

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textRes),
            fontSize = 27.sp,
        )
        Image(
            painter = painterResource( id = imageRes ),
            modifier = Modifier.size(200.dp),
            contentDescription = null
        )
        Text(
            text = stringResource(id = textRes2),
            fontSize = 20.sp,
            lineHeight = 40.sp
        )
    }
}

// Funkcja do wyświetlania dodatkowych opcji
@Composable
fun extraOptions(
    modifier: Modifier,
    onClickSingle: () -> Unit,
    onClickAll: () -> Unit,
    textRes: Int,
    textRes2: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /* TODO: Dodamy funkcję później */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.White)
                .padding(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            shape = RoundedCornerShape(30.dp),
        ) {
            Text(
                text = stringResource(id = textRes),
                fontSize = 30.sp,
            )
        }
        Button(
            onClick = { /* TODO: Dodamy funkcję później */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.White)
                .padding(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            shape = RoundedCornerShape(30.dp),
        ) {
            Text(
                text = stringResource(id = textRes2),
                fontSize = 30.sp,
            )
        }
    }
}

@Composable
fun displayInfo(
    modifier: Modifier,
    imageRes: Int,
    imageRes2: Int,
    textRes: Int,
    textRes2: Int,
    textRes3: Int
){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = textRes),
            fontSize = 27.sp,
            )
        Image(
            painter = painterResource( id = imageRes ),
            modifier = Modifier.size(200.dp),
            contentDescription = null
            )
        Text(
            text = stringResource(id = textRes2),
            fontSize = 20.sp,
            lineHeight = 40.sp
            )
        Image(
            painter = painterResource( id = imageRes2 ),
            modifier = Modifier.size(200.dp),
            contentDescription = null
        )
        Text(
            text = stringResource(id = textRes3),
            fontSize = 20.sp,
            lineHeight = 40.sp
        )

    }
}
@Preview(showBackground = true)
@Composable
fun BLEAppPreview() {
    AplikacjaBLETheme {
        backGround()
    }
}