    // Script para alternar tema
    const themeToggle = document.getElementById('themeToggle');
    const body = document.body;

    // Verifica se o tema está salvo no localStorage
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
      body.classList.add(savedTheme);
      themeToggle.textContent = savedTheme === 'dark-theme' ? '☀️ Light' : '🌙 Dark';
    }

    // Alterna o tema ao clicar no botão
    themeToggle.addEventListener('click', () => {
      body.classList.toggle('dark-theme');
      const isDarkTheme = body.classList.contains('dark-theme');
      themeToggle.textContent = isDarkTheme ? '☀️ Light' : '🌙 Dark';

      // Salva o tema no localStorage
      localStorage.setItem('theme', isDarkTheme ? 'dark-theme' : '');
    });


    // Seleciona o formulário e o modal
const form = document.querySelector('form');
const thankYouModal = new bootstrap.Modal(document.getElementById('thankYouModal'));

// Adiciona um evento de envio ao formulário
form.addEventListener('submit', (event) => {
  event.preventDefault(); // Impede o envio real do formulário

  // Exibe o modal de agradecimento
  thankYouModal.show();

  // Limpa os campos do formulário
  form.reset();
});