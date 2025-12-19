# Todo App - Part 3

Android-sovellus, joka hakee ja näyttää tehtävälistan JSONPlaceholder API:sta käyttäen Jetpack Compose -käyttöliittymää.

## 📱 Yleiskuvaus

Tämä on Android-sovellus, joka demonstroi modernia Android-kehitystä käyttäen:
- **Jetpack Compose** - Deklaratiivinen UI
- **Retrofit** - REST API -kutsuihin
- **ViewModel & MVVM** - Arkkitehtuuri
- **Kotlin Coroutines** - Asynkroninen ohjelmointi
- **Material 3** - Moderni ulkoasu

Sovellus hakee tehtävälistan JSONPlaceholder API:sta (`https://jsonplaceholder.typicode.com/todos`) ja näyttää ne listana.

## 🏗️ Projektin rakenne

```
app/src/main/java/com/example/todo/
├── model/
│   ├── Todo.kt              # Todo data class
│   └── TodoApiService.kt    # Retrofit API service
├── viewmodel/
│   └── ViewModel.kt         # TodoViewModel & UI state
├── ui/
│   ├── MainActivity.kt      # Pääaktiviteetti
│   ├── screen/
│   │   └── TodoScreen.kt    # UI komponentit
│   └── theme/
│       ├── Color.kt         # Väripaletti
│       ├── Theme.kt         # Teeman määrittelyt
│       └── Type.kt          # Typografia
```

## 🔧 Teknologiat ja kirjastot

### Kotlin & Android
- **Kotlin** - Ohjelmointikieli
- **Android SDK** - Android-kehitys

### Jetpack Libraries
- **Compose UI** - Deklaratiivinen käyttöliittymä
- **Material 3** - Material Design 3 komponentit
- **ViewModel** - UI-tilan hallinta
- **Lifecycle** - Elinkaaren hallinta

### Verkkokirjastot
- **Retrofit 2** - HTTP-asiakas REST API:lle
- **Gson Converter** - JSON-serialisointi

### Coroutines
- **Kotlin Coroutines** - Asynkroninen ohjelmointi
- **ViewModelScope** - ViewModel:iin sidottu coroutine scope

## 📦 Komponentit

### Model
- **Todo**: Data class, joka sisältää:
  - `userId: Int`
  - `id: Int`
  - `title: String`
  - `completed: Boolean`

- **TodosApiService**: Retrofit-palvelu API-kutsuihin
  - Singleton-toteutus
  - Base URL: `https://jsonplaceholder.typicode.com/`
  - Endpoint: `GET /todos`

### ViewModel
- **TodoViewModel**: Hallitsee UI:n tilaa ja API-kutsuja
  - `TodoUiState.Loading` - Lataus käynnissä
  - `TodoUiState.Success` - Data haettu onnistuneesti
  - `TodoUiState.Error` - Virhe tapahtui

### UI Components
- **TodoApp**: Pääkomponentti Scaffold-rakenteella
- **TodoScreen**: Näyttää eri UI-tilat
- **TodoList**: LazyColumn-lista tehtävistä
- **LoadingScreen**: Latausindikaattori
- **ErrorScreen**: Virheilmoitus

## 🚀 Asennus ja käynnistys

### Vaatimukset
- Android Studio (uusin versio)
- JDK 11 tai uudempi
- Android SDK (API 24+)
- Internet-yhteys (API-kutsuihin)

### Asennusohjeet

1. **Kloonaa repositorio**
```bash
git clone https://github.com/c3sean00/Todopart3.git
cd Todopart3
```

2. **Avaa projekti Android Studiossa**
   - File → Open → Valitse projektin kansio

3. **Synkronoi Gradle**
   - Android Studio synkronoi automaattisesti
   - Tai: File → Sync Project with Gradle Files

4. **Käynnistä sovellus**
   - Kytke Android-laite USB:llä tai käynnistä emulaattori
   - Run → Run 'app' (tai paina Shift + F10)

## 💡 Käyttö

1. Sovellus käynnistyy ja alkaa hakea dataa API:sta automaattisesti
2. Näkyy "Loading..." -teksti latauksen aikana
3. Onnistuneen haun jälkeen näytetään lista tehtävistä
4. Jos virhe tapahtuu, näytetään virheilmoitus

## 🎨 UI/UX Ominaisuudet

- **Material 3 Design** - Moderni ulkoasu
- **Dynamic Color** - Tukee Android 12+ dynaamisia värejä
- **Dark/Light Mode** - Automaattinen teeman vaihto
- **Lazy Loading** - Tehokas lista-renderöinti
- **Error Handling** - Käyttäjäystävälliset virheilmoitukset

## 🔄 Tietovirta

```
MainActivity 
    ↓
TodoApp (Scaffold + TopAppBar)
    ↓
TodoViewModel (käynnistää API-haun)
    ↓
TodosApiService (Retrofit-kutsu)
    ↓
JSONPlaceholder API
    ↓
TodoUiState päivittyy
    ↓
TodoScreen renderöi uuden tilan
```

## 🧪 Testaus

Projekti sisältää:
- **Unit testit**: `app/src/test/` - Yksikkötestit
- **Instrumented testit**: `app/src/androidTest/` - Android-laitetesteille

Suorita testit:
```bash
./gradlew test           # Yksikkötestit
./gradlew connectedTest  # Instrumented testit
```

## 👤 Tekijä

[c3sean00](https://github.com/c3sean00)

## 🔗 Linkit

- Repository: [https://github.com/c3sean00/Todopart3](https://github.com/c3sean00/Todopart3)
- JSONPlaceholder API: [https://jsonplaceholder.typicode.com/](https://jsonplaceholder.typicode.com/)

## 📚 Oppimistulokset

Tämä projekti demonstroi:
- ✅ REST API:n käyttöä Retrofitilla
- ✅ Jetpack Composen perusteita
- ✅ MVVM-arkkitehtuuria
- ✅ Kotlin Coroutines -käyttöä
- ✅ Material 3 UI-komponentteja
- ✅ State management -periaatteita
- ✅ Error handlingia asynkronisessa ohjelmoinnissa
