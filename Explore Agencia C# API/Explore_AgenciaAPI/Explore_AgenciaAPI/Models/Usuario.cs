using System.ComponentModel.DataAnnotations.Schema;

namespace Explore_AgenciaAPI.Model
{
    public class Usuario
    {
        public int Id { get; set; }
        [ForeignKey("id_cargo")]
        public Cargo  cargo { get; set; }
        public string Nome { get; set; }
        public int Cpf { get; set; }
        public string Email { get; set; }
        public int Password { get; set; }
    }
}
