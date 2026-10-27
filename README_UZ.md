# VocabKun Android APK loyihasi

- Lug‘at `app/src/main/assets/words.json` ichida, shu sabab lug‘at offline ishlaydi.
- Interfeys `index.html` ichida.
- Eslatma sahifasida 5 yoki 10 daqiqani tanlab **Bildirishnomani yoqish** tugmasini bosing. Android mahalliy bildirishnoma yaratadi; internet shart emas.
- Android 13+ da bildirishnoma ruxsatini bering. Telefonning batareya optimizatsiyasi ba’zi bildirishnomalarni kechiktirishi mumkin.

## APK olish (Android Studio talab qilinmaydi)
1. GitHub’da `vocabkun` repository oching.
2. ZIP ichidagi fayllarni repository ildiziga yuklang va commit qiling; `.github/workflows/build-apk.yml` ham yuklangan bo‘lsin.
3. GitHub repository → **Actions** → **Build VocabKun APK** → **Run workflow** (yoki push’dan keyin avtomatik tugashini kuting).
4. Yashil muvaffaqiyatli run’ni oching. Pastdagi **Artifacts** bo‘limidan `VocabKun-debug-apk` ni yuklab oling.
5. ZIP artifactni oching; `app-debug.apk` faylini Android telefoniga ko‘chiring va o‘rnating. Android “unknown apps” ruxsatini so‘rashi mumkin.

Bu debug APK bo‘ladi, Play Store uchun imzolangan release emas. GitHub Actions’dagi build va haqiqiy telefondagi sinovdan o‘tmaguncha to‘liq tekshirilgan deb hisoblamang.
