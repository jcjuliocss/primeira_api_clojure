(ns api-clojure.db
  (:require [next.jdbc :as jdbc]))

(def db-spec
  {:dbtype "postgresql"
   :dbname "testes"
   :host "127.0.0.1"
   :port 5432
   :user "postgres"
   :password "postgres"})

(def ds (jdbc/get-datasource db-spec))

(defn inserir-usuario
  "Insere um usuario no banco."
  [nome]
  (jdbc/execute! ds ["INSERT INTO usuarios (nome) VALUES (?)" nome]))

(defn buscar-usuario-nome
  "Busca um usuario do banco."
  [nome]
  (jdbc/execute! ds ["SELECT * FROM usuarios WHERE nome = ?" nome]))

(defn buscar-usuario-id
  "Busca um usuario do banco."
  [id]
  (jdbc/execute! ds ["SELECT * FROM usuarios WHERE id_usuario = ?" id]))

(defn buscar-usuarios
  "Lista todos os usuarios do banco."
  []
  (jdbc/execute! ds ["SELECT * FROM usuarios"]))