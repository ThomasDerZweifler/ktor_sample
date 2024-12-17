build project

./gradlew build

run project

./gradlew run

listen on http://localhost:8080

SSL (default ssl Port 443)

(ssl Verzeichnis im Projekt erstellen)
keytool -keystore ssl/keystore.jks -alias sampleAlias -genkeypair -keyalg RSA -keysize 4096 -validity 365 -dname 'CN=localhost, OU=ktor, O=ktor, L=Unspecified, ST=Unspecified, C=US' -ext 'SAN:c=DNS:localhost,IP:127.0.0.1'

in aplication.yaml angeben:

ktor:
  security:
    ssl:
      keyStore: ssl/keystore.jks
      keyAlias: sampleAlias
      keyStorePassword: myPassword
      privateKeyPassword: myPassword

2024-12-11 19:34:46.934 [DefaultDispatcher-worker-2] INFO  Application - Responding at http://0.0.0.0:8080
2024-12-11 19:34:46.934 [DefaultDispatcher-worker-2] INFO  Application - Responding at https://0.0.0.0:8443

Zertifikat exportieren (Nutzung von https://keystore-explorer.org/downloads.html)

https://localhost:8443

https://localhost:8443/json/kotlinx-serialization
