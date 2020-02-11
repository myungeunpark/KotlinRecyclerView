package com.example.kotlinrecyclerview

import com.example.kotlinrecyclerview.model.PostData

class DataSet {

    companion object{

        fun getDataSet() : List<PostData> {

            val list : List<PostData>
            list = ArrayList()

            list.add(
                PostData(
                    "https://www.w3schools.com/css/img_5terre.jpg",
                    "Terre", "Tom"
                )
            )
            list.add(
                PostData(
                    "https://www.w3schools.com/css/img_forest.jpg",
                    "Forest", "Marry Han"
                )
            )
            list.add(
                PostData(
                    "https://www.w3schools.com/css/img_lights.jpg",
                    "Light", "Catherin"
                )
            )
            list.add(
                PostData(
                    "https://www.w3schools.com/css/img_mountains.jpg",
                    "Mountain", "Mongo Kim"
                )
            )
            list.add(
                PostData(
                    "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                    "Havasu Falls", "Mike Koo"
                )
            )
            list.add(
                PostData(
                    "https://i.redd.it/tpsnoz5bzo501.jpg",
                    "Trondheim", "Sandy Jung"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/qn7f9oqu7o501.jpg",
                    "Portugal", "Wendy Kung"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/j6myfqglup501.jpg",
                    "Rocky Mountain National Park", "Sophie Han"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/0h2gm1ix6p501.jpg",
                    "Mahahual", "Sunny Moon"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/k98uzl68eh501.jpg",
                    "Frozen Lake", "Mike Park"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/glin0nwndo501.jpg",
                    "White Sands Desert", "Dorthy Min"
                )
            )

            list.add(
                PostData(
                    "https://i.redd.it/obx4zydshg601.jpg",
                    "Austrailia", "Sunsan Pho"
                )
            )

            list.add(
                PostData(
                    "https://i.imgur.com/ZcLLrkY.jpg",
                    "Washington", "Andy Young"
                )
            )

            return list
        }

    }
}