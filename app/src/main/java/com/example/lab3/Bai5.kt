package com.example.lab3

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab3.R
import com.google.android.material.internal.ViewUtils.RelativePadding

class Bai5 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Thanh toán")
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Menu, "")
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.DarkGray,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    )
                }, content = {
                    GetLayout(it)
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun GetLayout(
    innerPadding: PaddingValues = PaddingValues(0.dp)
) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.run {
            fillMaxSize()
                .background(color = Color("#363232".toColorInt()))
                .padding(
                    top = innerPadding.calculateTopPadding() + 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp,
                )

        },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GetDiaChi()
        GetRowItem(color = Color("#EB8B33".toColorInt()), R.drawable.ic_logo_paypal, "Paypal")
        GetRowItem(color = Color.Blue, R.drawable.ic_logo_visa, "VISA")
        GetRowItem(color = Color("#D93485".toColorInt()), R.drawable.ic_logo_momo, "MOMO")
        GetRowItem(color = Color("#57BFF7".toColorInt()), R.drawable.ic_logo_zalopay, "ZaloPay")
        GetRowItem(
            color = Color("#6EE8E8".toColorInt()),
            R.drawable.ic_logo_tttt,
            "Thanh toán tiền mặt"
        )
        Button(onClick = {}, shape = RoundedCornerShape(8.dp),modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(Color("#EB8B33".toColorInt()))
            ){
            Text(text = "Tiếp theo")
        }
        BottomNavigationBar()
    }
}


@Composable
fun GetRowItem(color: Color, idRes: Int = R.drawable.ic_logo_paypal, title: String = "Paypal") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape(12.dp))
            .height(70.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = idRes), contentDescription = "",
            modifier = Modifier
                .width(60.dp)
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(50.dp, 0.dp, 0.dp, 0.dp),
            color = Color.White,
        )
        RadioButton(selected = false, onClick = {

        })
    }
}

@Composable
fun GetDiaChi() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.LocationOn, contentDescription = "")
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Huy|222222222", color = Color.White)
            Text(text = "22/333 đường Trung Mỹ Tây 1",color = Color.White)
            Text(text = "Phường Tân Thới Nhất",color = Color.White)
            Text(text = "Quận 12 Thành Phố HCM",color = Color.White)

        }
    }
    Text(text = "Vui lòng chọn phương thức thanh toán: ",Modifier.padding(end = 60.dp),color = Color.White)
}
@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF262121),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = null) },

            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_calendar), contentDescription = null) },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = null) },

            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_person_24), contentDescription = null) },

            selected = false,
            onClick = {}
        )
    }
}