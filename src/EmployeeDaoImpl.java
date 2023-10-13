import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection;

    public EmployeeDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (bank_name,bank_email,bank_account_balance,cust_id) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getBank_name());
        preparedStatement.setString(2, employee.getBank_email());
        preparedStatement.setInt(3, employee.getBank_account_balance());
        preparedStatement.setInt(4, employee.getCust_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer credentials saved");

        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set bank_name = ?, bank_email = ?, bank_account_balance = ?, cust_id = ? where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getBank_name());
        preparedStatement.setString(2, employee.getBank_email());
        preparedStatement.setInt(3, employee.getBank_account_balance());
        preparedStatement.setInt(4, employee.getCust_id());
        preparedStatement.setInt(5, employee.getBank_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer credentials updated");
        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Employee deleted");
        } else {
            System.out.println("Oops! something went wrong");
        }


    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int bank_id = resultSet.getInt(1);
            String bank_name = resultSet.getString(2);
            String bank_email = resultSet.getString(3);
            int bank_account_balance = resultSet.getInt(4);
            int cust_id = resultSet.getInt(5);
            Employee employee = new Employee(bank_id, bank_name, bank_email, bank_account_balance, cust_id);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where bank_id =" + empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null) {
            int bank_id = resultSet.getInt(1);
            String bank_name = resultSet.getString(2);
            String bank_email = resultSet.getString(3);
            int bank_account_balance = resultSet.getInt(4);
            int cust_id = resultSet.getInt(5);
            employee = new Employee(bank_id, bank_name, bank_email, bank_account_balance, cust_id);
        } else {
            System.out.println("no record found");
        }
        return employee;

    }

    @Override
    public List<Employee> getAccountById(int empId) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee where cust_id =" + empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int bank_id = resultSet.getInt(1);
            String bank_name = resultSet.getString(2);
            String bank_email = resultSet.getString(3);
            int bank_account_balance = resultSet.getInt(4);
            int cust_id = resultSet.getInt(5);
            Employee employee = new Employee(bank_id, bank_name, bank_email, bank_account_balance, cust_id);
            employees.add(employee);
        }
        return employees;
    }


    @Override
    public Employee getBalanceById(int empId) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where bank_id =" + empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if (resultSet != null) {
            int bank_id = resultSet.getInt(1);
            String bank_name = resultSet.getString(2);
            String bank_email = resultSet.getString(3);
            int bank_account_balance = resultSet.getInt(4);
            int cust_id = resultSet.getInt(5);
            employee = new Employee(bank_id, bank_name, bank_email, bank_account_balance, cust_id);
        } else {
            System.out.println("no record found");
        }
        return employee;
    }

    @Override
    public void updateWithdrawal(Employee employee1) throws SQLException {
        String sql = "update employee set bank_account_balance = ? where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee1.getBank_account_balance());
        preparedStatement.setInt(2, employee1.getBank_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance updated");
        } else {
            System.out.println("Oops! something went wrong");
        }


    }

    @Override
    public void updateDeposit(Employee employee2) throws SQLException {
        String sql = "update employee set bank_account_balance = ? where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee2.getBank_account_balance());
        preparedStatement.setInt(2, employee2.getBank_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance updated");
        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void addLogin(Login login) throws SQLException {
        String sql = "insert into login (name,email,mobile_no,address) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, login.getName());
        preparedStatement.setString(2, login.getEmail());
        preparedStatement.setInt(3, login.getMobile_no());
        preparedStatement.setString(4, login.getAddress());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Logged in successfully");

        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "insert into transaction (transfered_from_bank_id,transfered_to_bank_id,amount_transfered) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transaction.getTransfered_from_bank_id());
        preparedStatement.setInt(2, transaction.getTransfered_to_bank_id());
        preparedStatement.setInt(3, transaction.getAmount_transfered());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Transaction details saved");

        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void addBalance(Employee employee7) throws SQLException {
        String sql = "update employee set bank_account_balance = ? where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee7.getBank_account_balance());
        preparedStatement.setInt(2, employee7.getBank_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance updated for receiver");

        } else {
            System.out.println("Oops! something went wrong");
        }

    }

    @Override
    public void deductBalance(Employee employee6) throws SQLException {
        String sql = "update employee set bank_account_balance = ? where bank_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee6.getBank_account_balance());
        preparedStatement.setInt(2, employee6.getBank_id());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Balance updated for sender");

        } else {
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public List<Transaction> getTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "select * from transaction";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int transfered_from_bank_id = resultSet.getInt(1);
            int transfered_to_bank_id = resultSet.getInt(2);
            int amount_transfered = resultSet.getInt(3);
            Transaction transaction = new Transaction(transfered_from_bank_id,transfered_to_bank_id,amount_transfered);
            transactions.add(transaction);
        }
        return transactions;
    }





}
