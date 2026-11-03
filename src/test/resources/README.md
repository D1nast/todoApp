# テスト実行コマンド
SPRING_PROFILES_ACTIVE=prd ./gradlew clean test

curl -v -X POST -H "Content-Type: application/json" -d @user.json http://localhost:10000/api/create