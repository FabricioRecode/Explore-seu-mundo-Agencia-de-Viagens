using System.ComponentModel.DataAnnotations.Schema;

namespace Explore_AgenciaAPI.Model
{
    public class Pacote
    {
        public int Id { get; set; }
        [ForeignKey("id_cidade")]
        public Cidade cidade { get; set; }
        public double Preco { get; set; }    
        public double Diaria { get; set; }
        public Boolean Cafe_manha { get; set; } 
    }
}
