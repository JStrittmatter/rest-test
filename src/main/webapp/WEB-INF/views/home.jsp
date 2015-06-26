<%--@elvariable id="payroll" type="org.jstrittmatter.model.Payroll"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.servletContext.contextPath}/resources/jquery-1.11.3.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/jquery.json.min.js"
            type="text/javascript"></script>
    <script type="application/javascript">
        $(document).ready(function () {
            var index = 0;
            $("#add").on('click', function () {
                var html = "<div id='deduction'>";
                html = html + "<div><label>Deduction Amount:</label>";
                html = html + "<input name=\"deduction[" + index + "].amount\"/></div>";
                html = html + "<div><label>Pre Tax:</label><input type=\"checkbox\" name=\"deduction[" + index + "].preTax\" /></div></div>";

                $('#deductions').html($('#deductions').append(html).html());
                index++;

            });
            $.fn.serializeObject = function () {
                var o = {};
                var a = this.serializeArray();
                $.each(a, function () {
                    if (o[this.name] !== undefined) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };
            $("#payrollForm").on('submit', function (e) {
                e.preventDefault();
                var data = $.extend({}, $('#payrollForm').serializeObject(), $('#deductionsForm').serializeObject());
                var formData = JSON.stringify(data);
                $.ajax({
                    type: "POST",
                    contentType: 'application/json',
                    dataType: 'json',
                    url: "/sendPayroll",
                    data: formData,
                    success: function (result) {
                        alert("Thank you for sending your Payroll");
                        $('#results').text(JSON.stringify(result));
                    }
                });
            });
        })
    </script>
</head>
<body>
<div id="content">
    <form:form id="payrollForm" modelAttribute="payroll" method="post">
        <div><label>First Name:</label><form:input path="firstName" title="First Name"/></div>
        <div><label>Last Name:</label><form:input path="lastName" title="Last Name"/></div>
        <div><label>Gross Amount:</label><form:input path="grossAmount" title="Gross Amount"/></div>
        <div><label>Federal Tax Rate:</label><form:input path="federalTaxRate" title="Federal Tax Rate"/></div>
        <div><label>State Tax Rate:</label><form:input path="stateTaxRate" title="State Tax Rate"/></div>
        <div><label>Deductions: </label>

            <div id="deductions">
            </div>
            <button id="add" type="button">Add Deduction</button>
        </div>

        <input id="send" type="submit" value="Send">
    </form:form>

    <div id="results"></div>
</div>
</body>
</html>
