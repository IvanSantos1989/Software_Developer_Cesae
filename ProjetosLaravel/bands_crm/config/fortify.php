<?php

use Laravel\Fortify\Features;

return [

    'guard' => 'web',
    'passwords' => 'users',
    'username' => 'email',
    'email' => 'email',

    'limiters' => [
        'login' => 'login',
    ],

    'features' => [
        Features::registration(),
        Features::resetPasswords(),
        // Features::emailVerification(), // opcional
        Features::updateProfileInformation(),
        Features::updatePasswords(),
        // Features::twoFactorAuthentication([
        //     'confirm' => true,
        //     'confirmPassword' => true,
        // ]),
    ],
];