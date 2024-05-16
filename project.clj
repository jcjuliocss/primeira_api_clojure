(defproject api-clojure "0.1.0-SNAPSHOT"
  :description "API clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.9.3"]
                 [ring/ring-jetty-adapter "1.9.3"]
                 [ring/ring-defaults "0.3.3"]
                 [compojure "1.6.2"]
                 [seancorfield/next.jdbc "1.1.613"]
                 [org.postgresql/postgresql "42.2.20"]]
  :main ^:skip-aot api-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
