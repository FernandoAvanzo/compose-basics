package jetpack.compose.composebasics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
            MyApp { MyScreenContent() }
        }
    }
}

@Composable
fun MyScreenContent(
    names: List<String> = List(1000) { "Hello Jaguara =>$it" },
    stateCounter: MutableState<Int> = remember { mutableStateOf(0) }
) = Column(modifier = Modifier.fillMaxHeight()) {
    NameList(names = names, Modifier.weight(1f))
    Counter(stateCounter.value) {
        stateCounter.value = it
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) =
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name)
            Divider(color = Color.Black)
        }
    }

@Composable
fun Counter(count: Int, counter: (Int) -> Unit) =
    Button(
        onClickAction(count = count, counter = counter),
        colors = ButtonDefaults.buttonColors(
            colorButtonRule(count = count)
        )
    ) {
        Text("I've been clicked $count times")
    }


fun colorButtonRule(count: Int) = count
    .takeIf { it > 5 }?.let { Color.Green } ?: Color.White

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
