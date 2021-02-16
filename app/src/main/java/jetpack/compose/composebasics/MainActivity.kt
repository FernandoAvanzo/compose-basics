package jetpack.compose.composebasics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun MyScreenContent(names: List<String> = listOf("Jaguara", "there")) = Column {
    val count = remember { mutableStateOf(0) }
    names.map {
        Greeting(it)
        Divider(color = Color.Black)
    }
    Divider(color = Color.Transparent, thickness = 32.dp)
    Counter(count.value) {
        count.value = it
    }
}

@Composable
fun Counter(count: Int, counter: (Int) -> Unit) {
    Button(onClickAction(count = count, counter = counter)) {
        Text("I've been clicked $count times")
    }
}

fun onClickAction(count: Int, counter: (Int) -> Unit): () -> Unit = {
    counter(count + 1)
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
