package jetpack.compose.composebasics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.compose.composebasics.ui.theme.BasicsCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyScreenContent()= Column {
    Greeting("Jaguara")
    Divider(color = Color.Black)
    Greeting("there")
}

@Composable
fun MyApp(content: @Composable () -> Unit) = BasicsCodelabTheme {
    Surface(color = Color.Yellow) {
        content()
    }
}


@Composable
fun Greeting(name: String = "") = Text(
    text = "Hello $name",
    modifier = Modifier.padding(24.dp)
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() = MyApp {
    MyScreenContent()
}
