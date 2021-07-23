<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>showMaker</title>
</head>
<body>
    <div >
        <table>
            <thead>
            <#list titles as title >
                <th>
                    title
                </th>
            </#list>
            </thead>
            <tbody>
                <#list values as value>
                    <tr>
                        <td>${value.name}</td>
                        <td>${value.age}</td>
                    </tr>
                <#else>
                    <tr>
                        <td>empty</td>
                        <td></td>
                    </tr>
                </#list>
            </tbody>

        </table>
    </div>
</body>
</html>