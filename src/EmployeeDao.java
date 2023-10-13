import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployees() throws SQLException;
    Employee getEmployeeById(int id) throws  SQLException;
    List<Employee> getAccountById(int id) throws  SQLException;


    Employee getBalanceById(int id) throws SQLException;

    void updateWithdrawal(Employee employee) throws SQLException;
    void updateDeposit(Employee employee) throws SQLException;

    void addLogin(Login login) throws SQLException;

    void addTransaction(Transaction transaction) throws SQLException;
    void addBalance(Employee employee) throws SQLException;

    void deductBalance(Employee employee) throws SQLException;
    List<Transaction> getTransactions() throws SQLException;



}
