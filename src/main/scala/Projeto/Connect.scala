package Projeto
import akka.actor.ActorSystem

import java.sql.{Connection, DriverManager, ResultSet}
import scala.concurrent.ExecutionContextExecutor
case class Connect() {
  object SQLServerConnection {
    // Configuração do servidor
    implicit val system: ActorSystem = ActorSystem("my-system")
    //implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    // Configurações de conexão com o banco de dados SQL Server
    val url = "jdbc:sqlserver://;servername=DESKTOP-G0TT3JA\\SQLEXPRESS;databaseName=DB"
    val username = "hollemax"
    val password = "cidadao"

    // Função para executar uma consulta SQL
    def executeQuery(sql: String): Seq[String] = {
      var connection: Connection = null
      var resultSet: ResultSet = null
      var resultSeq: Seq[String] = Seq.empty

      try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement()
        resultSet = statement.executeQuery(sql)

        while (resultSet.next()) {
          // Aqui você pode acessar os resultados do ResultSet
          val column1Value = resultSet.getString("Nome")
          val column2Value = resultSet.getString("Descricao")
          // Adicione os dados ao resultado
          resultSeq :+= s"$column1Value - $column2Value"
        }
      } catch {
        case e: Exception => e.printStackTrace()
      } finally {
        // Fechar recursos
        if (resultSet != null) resultSet.close()
        if (connection != null) connection.close()
      }
      return resultSeq;
    }
  }
}
