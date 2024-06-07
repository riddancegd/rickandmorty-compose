<h1 align="center">Rick and Morty Compose</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href=""><img alt="Build Status" src="https://github.com/skydoves/pokedex-compose/workflows/Android%20CI/badge.svg"/></a> <br>
  <a href="https://github.com/riddancegd"><img alt="Profile" src="https://img.shields.io/badge/Github-riddancegd-4574e0?logo=github"/></a> 
</p>

<p align="center">  
🗡️ This app demonstrates modern Android development with Jetpack Compose, Hilt, Coroutines, Flow, Jetpack ViewModel, and Material Design based on MVVM architecture.
</p>

<p align="center">
<img src="preview/preview.gif"/>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.
- Jetpack Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - Navigation: Facilitates screen navigation, complemented by [Hilt Navigation Compose](https://developer.android.com/jetpack/compose/libraries#hilt) for dependency injection.
  - Room: Constructs a database with an SQLite abstraction layer for seamless database access.
  - [Hilt](https://dagger.dev/hilt/): Facilitates dependency injection.
- Architecture:
  - MVVM Architecture (View - ViewModel - Model): Facilitates separation of concerns and promotes maintainability.
- [Retrofit2](https://github.com/square/retrofit): Constructs REST APIs and facilitates paging network data retrieval.
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization): Kotlin multiplatform / multi-format reflectionless serialization.
- [Landscapist Glide](https://github.com/skydoves/landscapist#glide), [animation](https://github.com/skydoves/landscapist#animation), [placeholder](https://github.com/skydoves/landscapist#placeholder): A pluggable, highly optimized Jetpack Compose and Kotlin Multiplatform image loading library that fetches and displays network images with Glide, Coil, and Fresco.

## Download
Go to the [Releases](https://github.com/riddancegd/rickandmorty-compose/releases) section to download the latest APK.

<img src="previews/preview.gif" align="right" width="320"/>

## Open API

<img src="https://res.cloudinary.com/dtbfspso5/image/upload/v1651778966/rick%20and%20morty/Rick-And-Morty-Logo_rdwvrn.png" align="right" width="21%"/>

This app makes use of the [Rick & Morty API](https://rickandmortyapi.com/) for constructing RESTful API.<br>
Providing a RESTful API interface to highly detailed objects built from thousands of lines of data related to Rick & Morty Characters.

## Find this repository useful? :heart:
__[follow me](https://github.com/riddancegd)__ on GitHub for more cool projects! 🐉

# License
```xml
Designed and developed by 2024 riddancegd (Jhibram Farid)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
