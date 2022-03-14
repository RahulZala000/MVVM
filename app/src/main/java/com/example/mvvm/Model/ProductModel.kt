package com.example.mvvm.Model



//@Entity(tableName = "Product")
data class ProductModel(

//    @PrimaryKey(autoGenerate = true)
    var id:Int,
 //   @ColumnInfo(name = "Title")
    var title:String,
   var price:Float,
//    @ColumnInfo(name="Desc")
    var description:String,
  //  @ColumnInfo(name = "Image")
    var image:String
)