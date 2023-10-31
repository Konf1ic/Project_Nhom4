<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            background-color: #333;
            color: #fff;
            padding: 10px;
        }

        input[type="text"], input[type="email"], input[type="number"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        button {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
        }

        button:hover {
            background-color: #555;
        }

        form {
            background-color: #fff;
            padding: 20px;
            margin: 20px 0;
        }

        #resetPasswordButton {
            margin: 20px 0;
        }

        /* Hiển thị thành công và lỗi */
        .success {
            color: green;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>QLTK NV</h1>

<!-- Ô tìm kiếm -->
<input type="text" id="searchInput" placeholder="Search by name or username">
<button onclick="searchAccounts()">Search</button>

<!-- Danh sách tài khoản nhân viên -->
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Name</th>
        <th>Age</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Pay</th>
    </tr>
    </thead>
    <tbody id="accountList">
    <!-- Dữ liệu tài khoản sẽ được hiển thị ở đây -->
    </tbody>
</table>

<!-- Form thêm mới tài khoản -->
<h2>Add NV</h2>
<form id="addAccountForm">
    <label for="newUsername">Username:</label>
    <input type="text" id="newUsername" required><br>

    <label for="newEmail">Email:</label>
    <input type="email" id="newEmail" required><br>

    <label for="newName">Name:</label>
    <input type="text" id="newName" required><br>

    <label for="newAge">Age:</label>
    <input type="number" id="newAge" min="19" max="59" required><br>

    <label for="newPhoneNumber">Phone:</label>
    <input type="tel" id="newPhoneNumber" required><br>

    <label for="newAddress">Address:</label>
    <input type="text" id="newAddress" required><br>

    <label for="newSalary">Pay:</label>
    <input type="number" id="newSalary" min="1" max="99999999" required><br>

    <button type="submit">Add</button>
</form>

<!-- Nút reset mật khẩu mặc định -->
<button id="resetPasswordButton" onclick="resetPassword()">Reset Pass</button>

<script>
    // JavaScript cho chức năng tìm kiếm và thêm mới tài khoản
    // Thêm JavaScript của bạn ở đây

    function searchAccounts() {
        // Xử lý tìm kiếm tài khoản theo tên hoặc username
    }

    function resetPassword() {
        // Xử lý reset mật khẩu về mặc định
    }
</script>
</body>
</html>
