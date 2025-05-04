# 🖥️ Fővárosok GUI – Grafikus felületű alkalmazás

Ez a projekt egy grafikus felhasználói felületet (GUI) valósít meg a `fovaros.csv` fájl adatainak megjelenítésére és kezelésére. A fájl országok, országjelek, fővárosok és lakosságszám adatait tartalmazza.

---

## 📁 Fájl: `fovaros.csv`
- **Formátum**: `Ország;Országjel;Főváros;Népesség`
- **Kódolás**: UTF-8
- **Elválasztó**: `;` (pontosvessző)
- ⚠️ **Az első sor fejléc!**

---

## ⚙️ Projekt neve: `FovarosGUI`

Készítsük el a `FovarosGUI` nevű Java projektet a következő specifikációk alapján:

---

## 📌 Feladatok

### 1️⃣ Grafikus felület létrehozása *(2 pont)*
- A grafikus felület a megadott **mintához** igazodjon.
- Legyen egy **Fájl** menü, benne:
  - `Megnyitás` (Ctrl+O)
  - `Kilépés` (Ctrl+Q)
- A **lista** mérete: `300x300` pixel, **de** kövesse az ablak méretét!
- A listaelemek **NE érjenek össze** (pl. használjunk szegélyt vagy paddinget).

---

### 2️⃣ CSV fájl megnyitása és betöltése *(3 pont)*
- A `Megnyitás` menüpont egy **fájlválasztó** ablakot nyisson meg:
  - Alapértelmezett könyvtár: a projekt mappája
  - Csak `*.csv` fájlokat lehessen kiválasztani
- Az adatokat olvassuk be egy **megfelelő adatszerkezetbe** (pl. lista).
- A beolvasott adatokat jelenítsük meg a **listában** a minta alapján.

🧩 **Java FileChooser példa**:
```java
private FileChooser fc = new FileChooser();
fc.setInitialDirectory(new File("./"));
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV fájlok", "*.csv"));
File fbe = fc.showOpenDialog(lsLista.getScene().getWindow());
