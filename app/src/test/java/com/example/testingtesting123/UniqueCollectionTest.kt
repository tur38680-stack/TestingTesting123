package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val original = collection.size()
        collection.addItem(Item("Granny Smith Apple"))
        val newSize = collection.size()
        assert(collection.get(0) == Item("Granny Smith Apple"))
        assert(original != newSize)
        assert(newSize == 1)
        collection.addItem(Item("2nd Item"))
        assert(collection.size() == 2)
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Banana"))
        collection.addItem(Item("Banana"))
        collection.addItem(Item("BANANA"))
        collection.addItem(Item("banana"))
        assert(collection.size() == 1)


    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun removeAnItem(){
        collection.addItem(Item("item1"))
        collection.remove(Item("item1"))
        assert(collection.size() == 0)
        collection.remove(Item("item1"))
        assert(collection.size() == 0)
    }
}