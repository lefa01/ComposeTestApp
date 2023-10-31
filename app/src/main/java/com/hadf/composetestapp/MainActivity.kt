package com.hadf.composetestapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.unit.dp
import com.hadf.composetestapp.ui.theme.ComposeTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                val personRepository = PersonRepository()
                val getAllData = personRepository.getAllData()

                LazyColumn(
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    itemsIndexed(
                        items = getAllData,
                        key = {index, person ->
                            person.id
                        }
                    ) {index,  person ->
                        Log.d("MainActivity", index.toString())
                        CustomItem(person = person)
                    }
                }
            }
        }
    }
}

