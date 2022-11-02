using System.ComponentModel.DataAnnotations;

namespace Explore_AgenciaAPI.Model
{
    public class Cargo
    {
        [Key]
         public int Id { get; set; }

         public string Nome { get; set; }
    }
}
