# アプリケーション起動
 ./gradlew bootRun

# 課題
タスク追加時のバリデーションエラー
　パスaddに遷移した後にバリデーションメッセージ
　　パス移動せずにバリデーションエラーを表示させたい
　バリデーションエラー時リダイレクトさせるとDBからの値取得できていない
　　バリデーションメッセージを表示させつつ、タスク一覧は維持したい
ServiceクラスのTransactional
　付加する意味
　付加したことによる効果
各メソッドのテスト
　単体テスト
　結合テスト
　E2Eテスト

依存関係の確認方法 
    BCryptがSecurityの一部であることは公式サイトのどこを見れば確認できるのか

SpringSecurityの理解 
    FilterChainとか 
    強制的にログイン画面にリ ダイレクトするのかとか

# 知識
Spring Security
    必要なもの
        @EnableWebSecurityが必要
        SecurityFilterChain
            どのパスのリクエストを認証・認可を必要とするかなど
        UserDetailsService
            inMemoryでユーザー情報保持してくれる
        Set up Spring Securityに記載あり
            https://spring.io/guides/gs/securing-web

application.properties
    https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config.files.profile-specific
    applicationの後ろに環境名つければ環境に応じた変数を読み込める

SpringSessionを使いたい
    https://docs.spring.io/spring-session/reference/guides/boot-jdbc.html#httpsession-jdbc-boot-sample
    依存関係を追加すれば自動設定してくれる
    デフォルトがHttpSessionで、それを自動でSpringSessionに代替してくれる
    分散化されたDBでもSessionを使える
    DBにセッション情報を保持したいから
        冗長構成を考慮に入れたログイン機能を作りたい
    ローカルはH2を使用
        dependencyに追加するだけで自動設定してくれる
        https://docs.spring.io/spring-session/reference/guides/boot-jdbc.html?utm_source=chatgpt.com


userDetailServiceとuserDetailsがユーザー情報をインメモリで保持する

IDとパスワード入れてもログインできない
    H2のデータベースができていない
    Spring Securityのデフォルトログインページのメソッドに問題がある

SpringSecurity導入
    SpringSecurityでのログイン
        SpringSession導入
            SpringSessionでのログイン



デフォルトがHttpSessionで、それを自動でSpringSessionに代替してくれる 
    Sessionごとにユーザー情報を保持するのがUserDetails


# 認証機能
SecurityConfigがSpringSecurity設定
コードの書き方は公式ドキュメントを参照
https://spring.io/guides/gs/securing-web

恐らく、/loginで入力されたID・PASSと、UserDetailsServiceの情報をDAOがチェックしている
https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/dao-authentication-provider.html#servlet-authentication-daoauthenticationprovider

# DB
## ローカル環境
H2データベースを使用
公式サイトではクラスが記載されているが、ローカルであるため参考書籍「作って学ぶSpringBoot入門」ページ64ページを参考
https://docs.spring.io/spring-framework/reference/data-access/jdbc/embedded-database-support.html