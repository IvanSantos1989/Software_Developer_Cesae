<?php
        include('./controllers/phpCode.php');
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/script.js" defer></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Olá Servidor</h1>

    <h4> <?= $helloWorld?> </h4>

    <!-- funciona como if/else -->
    <h2>Olá <?= $name ? $name : 'utilizador' ?></h2>

<p><?= plus(6, 8) ?></p>
<!-- abaixo a segundo forma de fazer a mesma coisa, mas sem o echo -->
<!-- <?php echo plus(6, 8); ?> -->

<p>Olá <?= fullname('Ivanildo', 'Silva') ?></p>

<p>Olá <?= $students[2] ?></p>

<?php
    foreach($students as $item){
        echo $item .'</br>';
    }
    ?>

    <hr>
    <ul>
    <?php
    foreach($modules as $key=>$value){
        echo "<li>O modulo de $key é dado por $value</li>";
    }
    ?>
    </ul>

    <hr>
    <ul>
        <?php
        foreach($cesaeData['data'] as $data){
            echo "<li>". $data['course']." e o ano é ". $data['year']."</li>";
        }
        ?>
    </ul>

</body>
</html>