
1. Comando para apresentar as evidências no ExtentReport e HTML formatado:

No Jenkins:

Manage Jenkins >> Script Console

Digitar o seguinte comando:

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")

Clicar em "Run"


2. Gerar um SSH para configuração no Jenkins

Abrir o prompt comando e digitar o seguinte comando:

ssh-keygen

Informar um usuario e <enter>
Informar uma senha e <enter>
Confirmar a enha e <enter>

Localizar o arquivo pelo usuario informado, copiar o conteudo do arquivo e informar no GitHub.
Copiar o conteudo do arquivo na mesma raiz com os dados da chave privada e informar no Jenkins pela opção de SSH.

