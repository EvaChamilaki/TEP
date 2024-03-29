function signInClicked() {
    $('#content_page').load('signin.html');
}

function logOutClicked() {
    $('#logout').css('display', 'none');
    $('#addPatient').css('display', 'none');
    $('#searchPatient').css('display', 'none');
    $('#signin').css('display', 'inline');
    $('#seePatients').css('display', 'none');
    $('#content_page').load('signin.html');
}


function addPatientInfoClicked() {
    $('#content_page').load('patientinfo.html', function () {
        $('#report').css('display', 'none');
        $('#reportlabel').css('display', 'none');
        $('#doctor').css('display', 'none');
        $('#doctorlabel').css('display', 'none');
        $('#therapy').css('display', 'none');
        $('#diagnose').css('display', 'none');
        $('#therapylabel').css('display', 'none');
        $('#diagnoselabel').css('display', 'none');
        $('#prescription').css('display', 'none');
        $('#examinations').css('display', 'none');
        $('#prescriptionlabel').css('display', 'none');
        $('#examinationslabel').css('display', 'none');
        $('#submitdiagnose').css('display', 'none');
        $('#submitexam').css('display', 'none');
    });
}

function addShiftClicked() {
$('#content_page').load('patientinfo.html', function () {
    });
}

function seePatientsClicked() {
    $('#content_page').load('patientinfo.html', function () {
        getPatient();
        $('#address').css('display', 'none');
        $('#addresslabel').css('display', 'none');
        $('#doctor').css('display', 'none');
        $('#doctorlabel').css('display', 'none');
        $('#submitdiagnose').css('display', 'inline');
        $('#submitexam').css('display', 'none');
        $('#submitpatient').css('display', 'none');

    });
}

function searchPatientInfoClicked() {
    $('#content_page').load('searchAmka.html');
}

$('#searchPatient').css('display', 'none');
$('#seePatients').css('display', 'none');
$('#addPatient').css('display', 'none');
$('#logout').css('display', 'none');


$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('container')) {
        $('#signinbtn').on('click', getUsers);
    }
});


$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('addpatient')) {
        $('#submitpatient').on('click', addPatient);
        $('#submitdiagnose').on('click', addDiagnose);
        $('#submitexam').on('click', addReport);

    }
});

$(document).on('DOMNodeInserted', function (e) {
    if ($(e.target).hasClass('searchamkadiv')) {
        $('#searchbtn').on('click', searchPatient);
    }
});