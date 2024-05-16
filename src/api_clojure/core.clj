(ns api-clojure.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]
            [api-clojure.db :as db]
            [api-clojure.routes :refer [app-routes]]))

(def app
  (wrap-defaults app-routes (assoc-in api-defaults [:security :anti-forgery] false)))

(defn -main
  "Funcao principal."
  [& args]
  (run-jetty app {:port 3000 :join? false}))
