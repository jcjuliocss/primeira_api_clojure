(ns api-clojure.routes
    (:require [compojure.core :refer :all]
              [compojure.route :as route]
              [api-clojure.db :as db]
              [ring.util.response :refer [response]]))

(defroutes app-routes
  (GET "/" [] "Primeira API em clojure!")
  (GET "/hello/:nome" [nome] (str "Ola, " nome "! Seja bem-vindo!"))
  (GET "/usuario/nome/:nome" [nome] 
    (let [usuario (db/buscar-usuario-nome nome)]
    (str usuario)))
  (GET "/usuario/id/:id" [id] 
    (let [usuario (db/buscar-usuario-id (Integer/parseInt id))]
    (str usuario)))
  (GET "/usuarios" []
    (let [usuarios (db/buscar-usuarios)]
    (str "Usuarios: " usuarios)))
  (POST "/usuario/inserir" [nome]
    (db/inserir-usuario nome)
    (str "Usuario inserido com sucesso!"))
  (route/not-found "Pagina nao encontrada."))
