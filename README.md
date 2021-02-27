# githubapiclient
RESTowy serwis, który zwraca:
-id
-login
-name
-type
-url avatar_url
-created_at
-obliczenia (6 / followers * (2 + public_repos))

Serwis pobier dane z: https://api.github.com/users/{login} oraz zapisuje w bd liczbe wywołań dla każdego loginu.
