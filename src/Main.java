import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //employee dao
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("PRESS 1: New User");
            System.out.println("PRESS 2: Customer");
            System.out.println("PRESS 3: Bank Employee");
            System.out.println("*** NOTE: You have to login in order to Apply for a New Account (New User>Login) ***");

                int input1 = scanner.nextInt();
                switch (input1) {
                    case 3: {
                        while (flag) {
                            System.out.println("*****************************");
                            System.out.println("Select from the option below");
                            System.out.println("*****************************");
                            System.out.println("PRESS 1 : Register for a Customer Account");
                            System.out.println("PRESS 2 : Reject an Account");
                            System.out.println("PRESS 3 : Show Customer's Account Balance");
                            System.out.println("PRESS 4 : Show All Bank Accounts");
                            System.out.println("PRESS 5 : View a particular Customer's Bank Account");
                            System.out.println("PRESS 6 : View All Accounts of a Customer");
                            System.out.println("PRESS 7 : View All Transactions");
                            System.out.println("PRESS 8 : Exit");


                        int input = scanner.nextInt();
                        switch (input) {
                            case 1: {
                                System.out.println("Enter Bank Name: ");
                                String bank_name = scanner.next();
                                System.out.println("Enter Bank Email: ");
                                String bank_email = scanner.next();
                                System.out.println("Enter Bank Balance: ");
                                int bank_account_balance = scanner.nextInt();
                                System.out.println("Enter Customer id: ");
                                int cust_id = scanner.nextInt();

                                Employee employee = new Employee();
                                employee.setBank_name(bank_name);
                                employee.setBank_email(bank_email);
                                employee.setBank_account_balance(bank_account_balance);
                                employee.setCust_id(cust_id);
                                employeeDao.addEmployee(employee);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter Customer Bank id: ");
                                int id = scanner.nextInt();

                                Employee employee = new Employee();
                                employeeDao.deleteEmployee(id);
                                break;
                            }
                            case 3: {
                                System.out.println("Enter Customer Bank id: ");
                                Integer empId = scanner.nextInt();
                                Employee employee = new Employee();
                                employee = employeeDao.getBalanceById(empId);
                                System.out.println(employee.getBank_account_balance());
                                break;

                            }
                            case 4: {
                                List<Employee> employeeList = employeeDao.getEmployees();
                                for (Employee employee : employeeList) {
                                    System.out.println(employee);
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Enter Customer Bank id: ");
                                int empId = scanner.nextInt();
                                Employee employee = new Employee();
                                employee = employeeDao.getEmployeeById(empId);
                                System.out.println(employee);
                                break;

                            }
                            case 6: {
                                System.out.println("Enter Customer id: ");
                                int empId = scanner.nextInt();
                                List<Employee> employeeList = employeeDao.getAccountById(empId);
                                for (Employee employee4 : employeeList) {
                                    System.out.println(employee4);
                                }
                                break;


                            }
                            case 7: {
                                    List<Transaction> transactionList = employeeDao.getTransactions();
                                    for (Transaction transaction1 : transactionList) {
                                        System.out.println(transaction1);
                                    }
                                    break;

                            }
                            case 8: {
                                System.out.println("Thank You");
                                System.out.println("Visit Again");
                                flag = false;
                                break;
                            }
                            default: {
                                System.out.println("choose between 1-8");
                            }
                            }

                        }
                    }
                    case 2: {
                        while (flag) {
                            System.out.println("****************************");
                            System.out.println("Select from the option below");
                            System.out.println("*****************************");
                            System.out.println("PRESS 1: Apply for New Bank Account");
                            System.out.println("PRESS 2: View Account Balance");
                            System.out.println("PRESS 3: Make a Withdrawal");
                            System.out.println("PRESS 4: Deposit Money");
                            System.out.println("PRESS 5: Transfer Money to Another Account");
                            System.out.println("PRESS 6: Accept Money from Another Account");
                            System.out.println("PRESS 7: Exit");

                            int input = scanner.nextInt();
                            switch (input) {
                                case 1: {
                                    System.out.println("Enter Bank Name: ");
                                    String bank_name = scanner.next();
                                    System.out.println("Enter Bank Email: ");
                                    String bank_email = scanner.next();
                                    System.out.println("Enter Bank Balance: ");
                                    int bank_account_balance = scanner.nextInt();
                                    System.out.println("Enter Customer id: ");
                                    int cust_id = scanner.nextInt();

                                    Employee employee = new Employee();
                                    employee.setBank_name(bank_name);
                                    employee.setBank_email(bank_email);
                                    employee.setBank_account_balance(bank_account_balance);
                                    employee.setCust_id(cust_id);
                                    employeeDao.addEmployee(employee);
                                    break;
                                }
                                case 2: {
                                    System.out.println("Enter Customer Bank id: ");
                                    Integer empId = scanner.nextInt();
                                    Employee employee = new Employee();
                                    employee = employeeDao.getBalanceById(empId);
                                    System.out.println(employee.getBank_account_balance());
                                    break;

                                }
                                case 3: {
                                    System.out.println("Enter Customer Bank id: ");
                                    Integer empId = scanner.nextInt();
                                    System.out.println("Withdrawal amount");
                                    Integer waId = scanner.nextInt();
                                    Employee employee = new Employee();

                                    employee = employeeDao.getBalanceById(empId);
                                    System.out.println("Withdrawal done");
                                    System.out.println("*******************");
                                    System.out.println("Current Account Balance: ");
                                    System.out.println(employee.getBank_account_balance()-waId);
                                    Employee employee1 = new Employee();
                                    employee1.setBank_account_balance(employee.getBank_account_balance()-waId);
                                    employee1.setBank_id(empId);
                                    employeeDao.updateWithdrawal(employee1);
                                    break;
                                }
                                case 4: {
                                    System.out.println("Enter Customer Bank id: ");
                                    Integer empId = scanner.nextInt();
                                    System.out.println("Deposit money");
                                    Integer daId = scanner.nextInt();
                                    Employee employee = new Employee();

                                    employee = employeeDao.getBalanceById(empId);
                                    System.out.println("Deposit done");
                                    System.out.println("*******************");
                                    System.out.println("Current Account Balance: ");
                                    System.out.println(employee.getBank_account_balance()+daId);
                                    Employee employee2 = new Employee();
                                    employee2.setBank_account_balance(employee.getBank_account_balance()+daId);
                                    employee2.setBank_id(empId);
                                    employeeDao.updateDeposit(employee2);
                                    break;

                                }
                                case 5: {
                                    System.out.println("Enter Bank id of Sender: ");
                                    int transfered_from_bank_id = scanner.nextInt();
                                    System.out.println("Enter Bank id of Receiver: ");
                                    int transfered_to_bank_id = scanner.nextInt();
                                    System.out.println("Enter Amount to be Transfered: ");
                                    int amount_transfered = scanner.nextInt();

                                    Transaction transaction = new Transaction();
                                    transaction.setTransfered_from_bank_id(transfered_from_bank_id);
                                    transaction.setTransfered_to_bank_id(transfered_to_bank_id);
                                    transaction.setAmount_transfered(amount_transfered);
                                    employeeDao.addTransaction(transaction);

                                    Employee employee8 = new Employee();
                                    employee8 = employeeDao.getBalanceById(transfered_from_bank_id);

                                    Employee employee6 = new Employee();
                                    employee6.setBank_account_balance(employee8.getBank_account_balance()-amount_transfered);
                                    employee6.setBank_id(transfered_from_bank_id);
                                    employeeDao.deductBalance(employee6);

                                    Employee employee9 = new Employee();
                                    employee9 = employeeDao.getBalanceById(transfered_to_bank_id);

                                    Employee employee7 = new Employee();
                                    employee7.setBank_account_balance(employee9.getBank_account_balance()+amount_transfered);
                                    employee7.setBank_id(transfered_to_bank_id);
                                    employeeDao.addBalance(employee7);
                                    break;
                                }


                                case 6: {
                                    System.out.println("Enter Bank id of Receiver ");
                                    int transfered_to_bank_id = scanner.nextInt();
                                    System.out.println("Enter Bank id of Sender: ");
                                    int transfered_from_bank_id = scanner.nextInt();
                                    System.out.println("Enter Amount to be Accepted: ");
                                    int amount_transfered = scanner.nextInt();


                                    Transaction transaction = new Transaction();
                                    transaction.setTransfered_from_bank_id(transfered_from_bank_id);
                                    transaction.setTransfered_to_bank_id(transfered_to_bank_id);
                                    transaction.setAmount_transfered(amount_transfered);
                                    employeeDao.addTransaction(transaction);

                                    Employee employee10 = new Employee();
                                    employee10 = employeeDao.getBalanceById(transfered_from_bank_id);

                                    Employee employee6 = new Employee();
                                    employee6.setBank_account_balance(employee10.getBank_account_balance()-amount_transfered);
                                    employee6.setBank_id(transfered_from_bank_id);
                                    employeeDao.deductBalance(employee6);

                                    Employee employee11 = new Employee();
                                    employee11 = employeeDao.getBalanceById(transfered_to_bank_id);

                                    Employee employee7 = new Employee();
                                    employee7.setBank_account_balance(employee11.getBank_account_balance()+amount_transfered);
                                    employee7.setBank_id(transfered_to_bank_id);
                                    employeeDao.addBalance(employee7);
                                    break;

                                }
                                case 7: {
                                    System.out.println("Thank You");
                                    System.out.println("Visit Again");
                                    flag = false;
                                    break;
                                }
                                default: {
                                    System.out.println("choose between 1-7");
                                }
                            }
                        }
                    }
                    case 1: {
                        while (flag) {
                            System.out.println("****************************");
                            System.out.println("Select from the option below");
                            System.out.println("*****************************");
                            while (flag) {
                                System.out.println("PRESS 1: Login");
                                System.out.println("PRESS 2: Register for a New Account");
                                System.out.println("PRESS 3: Exit");
                                int input = scanner.nextInt();
                                switch (input) {
                                    case 1: {
                                        System.out.println("Enter Name: ");
                                        String name = scanner.next();
                                        System.out.println("Enter Email: ");
                                        String email = scanner.next();
                                        System.out.println("Enter Mobile no.: ");
                                        int mobile_no = scanner.nextInt();
                                        System.out.println("Enter Address: ");
                                        String address = scanner.next();

                                        Login login = new Login();
                                        login.setName(name);
                                        login.setEmail(email);
                                        login.setMobile_no(mobile_no);
                                        login.setAddress(address);
                                        employeeDao.addLogin(login);
                                        break;

                                    }
                                    case 2: {
                                        System.out.println("Enter Bank Name: ");
                                        String bank_name = scanner.next();
                                        System.out.println("Enter Bank Email: ");
                                        String bank_email = scanner.next();
                                        System.out.println("Enter Bank Balance: ");
                                        int bank_account_balance = scanner.nextInt();
                                        System.out.println("Enter Customer id: ");
                                        int cust_id = scanner.nextInt();

                                        Employee employee = new Employee();
                                        employee.setBank_name(bank_name);
                                        employee.setBank_email(bank_email);
                                        employee.setBank_account_balance(bank_account_balance);
                                        employee.setCust_id(cust_id);
                                        employeeDao.addEmployee(employee);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Thank you");
                                        System.out.println("Visit Again");
                                        flag = false;
                                        break;
                                    }
                                    default: {
                                        System.out.println("choose between 1-3");
                                    }
                                    }
                            }
                        }

                    }
                    default: {
                        System.out.println("choose between 1-3");
                    }
                }
            }
        }
    }
