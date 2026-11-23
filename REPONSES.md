# TP1 : réponses

Nom : Andriamalala Tsikiniony Brady · Stack choisie : Spring Boot (JAVA)

## Étape 1 : API publique

| Appel | Statut | Content-Type | En-tête surprenant | Effet attendu |
|---|---|---|---|---|
| GET /posts/1 | 200 OK | application/json; charset=utf-8 | x-content-type-options: nosniff (sécurité), age: 1527 (réponse servie depuis un cache) | Lire l'article n°1, sans rien modifier côté serveur |
| GET /posts/99999 | 404 Not Found | application/json; charset=utf-8 | cf-cache-status: HIT (même une erreur 404 est mise en cache) | Lire l'article n°99999 : il n'existe pas, le serveur répond 404 avec un corps vide {} |
| POST /posts | 201 Created | application/json; charset=utf-8 | etag: W/"40-zfVCFoHc2WLG9qSNhANTwIIchp8" | Créer un nouvel article (auteur userId=1) ; le serveur lui attribue l'id 101 (simulé, rien n'est réellement enregistré) |
| DELETE /posts/1 | 200 OK | application/json; charset=utf-8 | etag: W/"2-vyGp6PvFo4RvsFtPoIWeCReyIC8" (corps de 2 octets : {}) | Supprimer l'article n°1 (simulé) ; beaucoup d'API répondraient plutôt 204 No Content |

L'URI nomme-t-elle une chose ou une action ? (une phrase)

L'URI nomme une chose (l'article 1, ou la collection /posts) ; l'action est indiquée par le verbe HTTP (GET, POST, DELETE).

## Étape 2 : SOAP et REST

| Critère | SOAP | REST |
|---|---|---|
| Verbe HTTP utilisé | POST| GET|
| URL | /service |/adherents?page=1&taille=20 |
| Où se trouve l'intention (opération) ? | Dans l'en-tête SOAPAction: "ListerAdherents" et dans la balise `<v:ListerAdherents>` du corps XML (l'URL /service ne dit rien) | Dans le verbe GET (lire) + l'URI /adherents (la ressource) |
| Taille approximative de la requête (octets) | ~430 octets | ~85 octets |
| Cache HTTP possible ? | Non : POST n'est pas mis en cache par HTTP | Oui : GET + Cache-Control: max-age=60 et ETag dans la réponse |