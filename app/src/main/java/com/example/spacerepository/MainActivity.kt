package com.example.spacerepository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spacerepository.data.SpaceObject
import com.example.spacerepository.data.SpaceRepository
import com.example.spacerepository.data.SpaceViewModel
import com.example.spacerepository.ui.theme.SpaceRepositoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceRepositoryTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceCardApp()
                }
            }
        }
    }
}

@Composable
fun SpaceCard(
    spaceObject: SpaceObject,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    OutlinedCard(
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            2.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .animateContentSize()
                .padding(16.dp)
        ) {
            // --- 1. ВЕРХНЯЯ ПАНЕЛЬ (День и Дистанция) ---
            TopBlog(spaceObject)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // --- 2. ЦЕНТР (Картинка и Название) ---
            ImageBlog(spaceObject)
            Spacer(modifier = Modifier.height(8.dp))
            Fact(spaceObject)
            // --- 3. ОТКРЫВАЮЩИЙСЯ БЛОК (Описание) ---
            ItemButton(expanded, onClick = { expanded = !expanded })
            DescriptionBlock(expanded, spaceObject)
        }
    }
}

@Composable
fun DescriptionBlock(
    expanded: Boolean,
    spaceObject: SpaceObject,
    modifier: Modifier = Modifier
) {
    if (expanded) {
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = ">> INITIALIZING DATA...",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(spaceObject.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 22.sp
                )
            }
        }
    }
}

@Composable
fun ItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun Fact(
    spaceObject: SpaceObject
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(spaceObject.funFactRes),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ImageBlog(
    spaceObject: SpaceObject,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        SpaceImage(spaceObject)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(spaceObject.nameRes).uppercase(),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun TopBlog(
    spaceObject: SpaceObject,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "DAY ${spaceObject.day.toString().padStart(2, '0')}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(spaceObject.distanceRes).uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}


@Composable
fun SpaceImage(spaceObject: SpaceObject, modifier: Modifier = Modifier) {
    var isPressed by remember { mutableStateOf(false) }
    var horizontalOffset by remember { mutableFloatStateOf(0f) }

    // Анимация масштаба (увеличиваем до 1.5)
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 1.5f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy),
        label = "scale"
    )

    // Анимация смещения по горизонтали
    val animatedOffsetX by animateFloatAsState(
        targetValue = if (isPressed) horizontalOffset else 0f,
        animationSpec = spring(Spring.DampingRatioLowBouncy),
        label = "offset"
    )

    // Эффект мерцания (пульсация масштаба)
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.98f, targetValue = 1.02f,
        animationSpec = infiniteRepeatable(tween(1500), RepeatMode.Reverse), label = "shimmer"
    )

    Image(
        painter = painterResource(id = spaceObject.imageRes),
        contentDescription = null,
        modifier = modifier
            .size(180.dp)
            // 1. ПОДНИМАЕМ КАРТИНКУ НАД ТЕКСТОМ
            .zIndex(if (isPressed) 1f else 0f)
            .onGloballyPositioned { coordinates ->
                val parentCoords = coordinates.parentLayoutCoordinates
                if (parentCoords != null) {
                    val parentCenterX = parentCoords.size.width / 2f
                    val itemCenterX =
                        coordinates.positionInParent().x + (coordinates.size.width / 2f)
                    horizontalOffset = parentCenterX - itemCenterX
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            }
            .graphicsLayer {
                scaleX = scale * pulse
                scaleY = scale * pulse
                translationX = animatedOffsetX

                // 2. ДОБАВЛЯЕМ ТЕНЬ (для визуального объема над текстом)
                shadowElevation = if (isPressed) 20f else 0f
                shape = if (spaceObject.isCircleShape) CircleShape else RoundedCornerShape(12.dp)
                clip = isPressed // Чтобы тень повторяла форму при увеличении
            }
            .clip(if (spaceObject.isCircleShape) CircleShape else MaterialTheme.shapes.medium),
        contentScale = ContentScale.Fit
    )

}


@Composable
fun SpaceCardApp() {
    val viewModel: SpaceViewModel = viewModel<SpaceViewModel>()

    val spaceObjects by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = { SpaceTopBar() }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + 16.dp, // Отступ первой карточки от баннера
                bottom = innerPadding.calculateBottomPadding() + 16.dp, // Отступ последней карточки от низа
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 2.dp)
        ) {
            items(spaceObjects, key = { it.day }) { spaceObject ->
                SpaceCard(spaceObject)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceTopBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun SpaceCardPrewiew() {
    SpaceRepositoryTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SpaceCardApp()
        }

    }
}